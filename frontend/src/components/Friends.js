import React from 'react';
import axios from 'axios';
import { Button, Col, Image, ListGroup, Row } from 'react-bootstrap';

const getBackendUserssUrl = (userid) =>
    `http://localhost:8089/v1/assesment/users/${userid}/friends`;

class Friends extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            friends: []
        };
    }

    componentDidMount() {
        // axios.get(getBackendUserssUrl())
        //     .then(response => response.data)
        //     .then(result => {
        //         let lastPageFlag = this.isLastPage(result);
        //         this.setState({ users: result.users, page: result.currentPage, lastpage: lastPageFlag });
        //     })
        //     .catch(err => console.log(err));
        if (this.props.location.state) {
            this.setState({ ...this.props.location.state }, () => {
                axios.get(getBackendUserssUrl(this.state.id))
                    .then(response => response.data)
                    .then(result => {
                        console.log(result);
                        this.setState({ friends: result });
                    })
                    .catch(err => console.log(err));
            });
        }
    }

    render() {
        return (
            <div className="container">
                <h1 className="page-header">{this.state.firstName} {this.state.lastName}'s Friends</h1>
                <ListGroup className="users-list my-5">
                    {
                        this.state.friends.map(user => {
                            return (
                                <ListGroup.Item key={user.id} className="user-data">
                                    <Row>
                                        <Col md={3}>
                                            <Image className="user-avatar" src={user.avatarUri} roundedCircle />
                                        </Col>
                                        <Col md={9} className="user-name-container">
                                            <h4 className="user-name">{user.firstName} {user.lastName}</h4>
                                        </Col>
                                    </Row>
                                </ListGroup.Item>
                            )
                        })
                    }
                </ListGroup>
                <Button variant="primary" onClick={()=>this.props.history.goBack()}>Back</Button>
            </div>
        )
    }
}

export default Friends;