import { useEffect, useState } from "react"
import axios from 'axios'

function MyArtifacts() {
    const [artifacts, setArtifacts] = useState([])
    const [loading, setLoading] = useState(false)


    useEffect(() => {
        setLoading(true)
        axios.get("http://localhost:8080/api/proforg/myartifacts/elizabethparker").then((response) => {
            console.table(response.data)
            setArtifacts(response.data)
            setLoading(false)
        })
    }, [])

    if (loading) {
        return (
            <h1>Loading</h1>
        )
    }


    return (
        <div className="container">
            {artifacts.map((artifact) => {
                return (
                    <>
                        <div class="card" key={artifact.artifact_id}>
                            <header class="card-header">
                                <p class="card-header-title">
                                    {artifact.title}
                                </p>
                                <button class="card-header-icon" aria-label="more options">
                                    <span class="icon">
                                        <i class="fas fa-angle-down" aria-hidden="true"></i>
                                    </span>
                                </button>
                            </header>
                            <div class="card-content">
                                <div class="content">
                                    {artifact.content}
                                    <br/>
                                        <time datetime="2016-1-1">11:09 PM - 1 Jan 2016</time>
                                </div>
                            </div>
                            <footer class="card-footer">
                                <a href="#" class="card-footer-item">View</a>
                                <a href="#" class="card-footer-item">Edit</a>
                                <a href="#" class="card-footer-item">Delete</a>
                            </footer>
                        </div>
                        <br/>
                    </>
                )
            })}
        </div>
    )
}

export default MyArtifacts