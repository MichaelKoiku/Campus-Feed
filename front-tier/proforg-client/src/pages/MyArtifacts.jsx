import { useEffect, useState } from "react"
import axios from 'axios'
import Card from "../components/Card"
import ImageCard from "../components/ImageCard"

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
                if (artifact.mediaUrl == null) {
                    return (
                        <Card key={artifact.artifact_id} props={artifact}/>
                    )
                } else {
                    return (
                        <ImageCard key={artifact.artifact_id} props={artifact}/>
                    )
                }
            }
            )
            }
        </div>
    )
}

export default MyArtifacts