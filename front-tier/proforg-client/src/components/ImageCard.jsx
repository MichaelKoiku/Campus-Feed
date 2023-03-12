function ImageCard({ props }) {

    const deleteArtifact = async (e) => {
        e.preventDefault();

        await fetch("http://localhost:8080/api/proforg/myartifacts/" + props.artifact_id, {
            method: "DELETE"
        })

        console.log("Delete Successful");
    }

    return (
        <div className="columns is-centered">
            <div className="column is-half">
                <div className="card card-equal-height mt-4">
                    <div className="card-image">
                        <figure className="image is-4by3">
                            <img src={props.mediaUrl} alt="Artifact image"></img>
                        </figure>
                    </div>
                    <hr />
                    <div className="card-content">
                        <div className="media">
                            <div className="media-content">
                                <p className="title is-4">{props.title}</p>
                                <p className="subtitle is-6">{"@" + props.username}</p>
                            </div>
                        </div>

                        <div className="content">
                            <p>{props.content}</p>
                            <br />
                            <a href={props.externalURL}>Click here for attached external link</a>

                            <p>{"#" + props.category}</p>
                            <p>{"#" + props.status}</p>

                            <br />
                            <time dateTime="2016-1-1">{props.artifactDateTime}</time>
                        </div>
                    </div>
                    <footer className="card-footer">
                        <button className="button is-normal is-fullwidth card-footer-item" onClick={(e) => deleteArtifact(e)}>Delete Artifact</button>
                    </footer>
                </div>
            </div>
        </div>
    )
}

export default ImageCard