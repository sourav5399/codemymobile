import axios from 'axios';
import React from 'react';
import { Fragment } from 'react';
import { Button, Card, Col, Image, ListGroup, Row } from 'react-bootstrap';
import './../App.css';

const getBackendUserssUrl = (page) =>
    `http://localhost:8089/v1/assesment/users?page=${page}&size=3`;

class Home extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            users: [],
            page: null,
        };
    }

    isLastPage = (data) => {
        if (data.currentPage === (data.totalPages - 1)) {
            return true;
        }
        return false;
    }

    componentDidMount() {
        axios.get(getBackendUserssUrl(0))
            .then(response => response.data)
            .then(result => {
                let lastPageFlag = this.isLastPage(result);
                this.setState({ users: result.users, page: result.currentPage, lastpage: lastPageFlag });
            })
            .catch(err => console.log(err));
    }

    handleClick(user) {
        this.props.history.push({ pathname: `/${user.id}/friends`, state: user});
    }   

    nextPageData = (event) => {
        console.log(this.state.page);
        axios.get(getBackendUserssUrl((this.state.page + 1)))
            .then(response => response.data)
            .then(result => {
                let lastPageFlag = this.isLastPage(result);
                let users = this.state.users;
                users.push(...result.users);
                console.log(users);
                this.setState({ users: users, page: result.currentPage, lastpage: lastPageFlag });
            })
            .catch(err => console.log(err));
    }

    render() {
        return (
            <div className="container">
                <h1 className="page-header">All Users</h1>
                <ListGroup className="users-list my-5">
                    {
                        this.state.users.map(user => {
                            return (
                                <ListGroup.Item key={user.id} className="user-data" onClick={this.handleClick.bind(this,user)}>
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
                {
                    this.state.lastpage
                    ?
                    null
                    :
                    <Button variant="primary" onClick={this.nextPageData}>More</Button>
                }
            </div>
        )
    }
}

export default Home;