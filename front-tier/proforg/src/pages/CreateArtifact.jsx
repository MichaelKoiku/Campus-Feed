import { useState } from "react";
import axios from 'axios'

function Feed() {
    const [title, setTitle] = useState("")
    const [content, setContent] = useState("")
    const [artifactType, setArtifactType] = useState("")
    const [externalLink, setExternalLink] = useState("")
    const [location, setLocation] = useState("")
    const [status, setStatus] = useState("")


    const handleFormSubmit = (e) => {
        e.preventDefault();
        console.log("SUBMITTED", title)

    }


    return (
        <div className="container">
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
                    <div className="control">
                        <label className="radio">
                            <input type="radio" name="artifactType" />
                            Post
                        </label>
                        <label className="radio">
                            <input type="radio" name="artifactType" />
                            Remote Event
                        </label>
                        <label className="radio">
                            <input type="radio" name="artifactType" />
                            Hybrid Event
                        </label>
                        <label className="radio">
                            <input type="radio" name="artifactType" />
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

                {/*Date + Time picker */}


                <div className="file has-name">
                    <label className="file-label">
                        <input className="file-input" type="file" name="file" />
                        <span className="file-cta">
                            <span className="file-icon">
                                <i className="fas fa-upload"></i>
                            </span>
                            <span className="file-label">
                                Choose a file…
                            </span>
                        </span>
                        <span className="file-name">
                            Screen Shot 2017-07-29 at 15.54.25.png
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