function Card({ props }) {

    return (
        <div className="columns is-centered">
            <div className="column is-half">
                <div className="card card-equal-height mt-4">
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
                        <a href="#" className="card-footer-item">View</a>
                        <a href="#" className="card-footer-item">Delete</a>
                    </footer>
                </div>
            </div>
        </div>
    )

}

export default Card