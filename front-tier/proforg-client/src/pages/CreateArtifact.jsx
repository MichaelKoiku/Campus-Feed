import { useState } from "react";
import axios from 'axios'

function Feed() {
    const [title, setTitle] = useState("")
    const [content, setContent] = useState("")
    const [artifactType, setArtifactType] = useState("")
    const [externalLink, setExternalLink] = useState(null)
    const [location, setLocation] = useState("")
    const [status, setStatus] = useState("")
    const [file, setFile] = useState();
    const [fileName, setFileName] = useState("...")
    const [mediaURL, setMediaURL] = useState(null)


    const handleFormSubmit = async (e) => {
        e.preventDefault();
        console.log("SUBMITTED", title)
        
        // get s3 link from server
        const {url} = await fetch("http://localhost:3000/s3").then(res => res.json())
        console.log(url)

        // post file to server
        await fetch(url, {
            method: "PUT",
            headers: {
                "Content-Type": "multipart/form-data"
            },
            body: file
        })
        setMediaURL(url.split('?')[0])
        console.log("media " + mediaURL)

        const body = {
            "username": "elizabethparker",
            "title": title,
            "content": content,
            "externalURL": externalLink,
            "category": artifactType,
            "status": status,
            "location": location,
            "artifactDateTime": null,
            "mediaUrl": mediaURL,
            "likesCount": 0
        }

        await fetch("http://localhost:8080/api/proforg/create", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: body
        })
        console.log(body)
        console.log("Artifact Created")
    }

    const stageFile = (e) => {
        e.preventDefault();
        setFile(e.target.files[0]);
        setFileName(e.target.files[0].name);
    }

    

    return (
        <div className="container">
            <br/>
            <form onSubmit={(e) => handleFormSubmit(e)}>
                <div className="field">
                    <label className="label">Title</label>
                    <div className="control">
                        <input className="input" type="text" placeholder="Title..." value={title} onChange={(e) => setTitle(e.target.value)} />
                    </div>
                </div>

                <div className="field">
                    <label className="label">Content</label>
                    <div className="control">
                        <textarea className="textarea is-large" placeholder="Content..." value={content} onChange={(e) => setContent(e.target.value)} />
                    </div>
                </div>

                <div className="field">
                    <div className="control" onChange={(e) => setArtifactType(e.target.value)}>
                        <label className="radio">
                            <input type="radio" name="artifactType" value={artifactType}/>
                            Post
                        </label>
                        <label className="radio">
                            <input type="radio" name="artifactType" value={artifactType}/>
                            Remote Event
                        </label>
                        <label className="radio">
                            <input type="radio" name="artifactType" value={artifactType}/>
                            Hybrid Event
                        </label>
                        <label className="radio">
                            <input type="radio" name="artifactType" value={artifactType}/>
                            In-person Event
                        </label>
                    </div>
                </div>

                <div className="field">
                    <label className="label">External Link</label>
                    <div className="control">
                        <input className="input" type="text" placeholder="External Link..." value={externalLink} onChange={(e) => setExternalLink(e.target.value)} />
                    </div>
                </div>

                <div className="field">
                    <label className="label">Location</label>
                    <div className="control">
                        <input className="input" type="text" placeholder="Location..." value={location} onChange={(e) => setLocation(e.target.value)} />
                    </div>
                </div>

                <div className="field">
                    <div className="control" onChange={(e) => setStatus(e.target.value)}>
                        <label className="radio">
                            <input type="radio" name="status" value={status}/>
                            Active
                        </label>
                        <label className="radio">
                            <input type="radio" name="status" value={status}/>
                            Pending Changes
                        </label>
                        <label className="radio">
                            <input type="radio" name="status" value={status}/>
                            Not Active
                        </label>
                        <label className="radio">
                            <input type="radio" name="status" value={status}/>
                            Cancelled
                        </label>
                    </div>
                </div>


                {/*Date + Time picker */}

                <div className="file has-name">
                    <label className="file-label">
                        <input className="file-input" type="file" name="file" onChange={(e) => stageFile(e)}/>
                        <span className="file-cta">
                            <span className="file-icon">
                                <i className="fas fa-upload"></i>
                            </span>
                            <span className="file-label">
                                Choose a file…
                            </span>
                        </span>
                        <span className="file-name">
                            {fileName}
                        </span>
                    </label>
                </div>
                <br />
                <button className="button is-medium is-fullwidth is-rounded">Create Artifact</button>

            </form>
        </div>
    )
}

export default Feed