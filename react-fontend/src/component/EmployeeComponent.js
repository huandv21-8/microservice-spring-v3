import React, { Component } from 'react';
import EmployeeService from '../service/EmployeeService';
import axios from 'axios';

class EmployeeComponent extends Component {

    var 

    constructor(props) {
        super(props);

        this.state = {
            employeeDto: {},
            departmentDto: {},
            organizationDto: {}
        }
    }

    componentDidMount() {
        
        axios.get('http://localhost:9191/employee/1')
            .then((response) => {
                console.log(response.data.employeeDto)

                this.setState({ employeeDto: response.data.employeeDto })
                this.setState({ departmentDto: response.data.departmentDto })
                this.setState({ organizationDto: response.data.organizationDto })
                // console.log(this.state.employeeDto)
                // console.log(this.state.departmentDto)
                // console.log(this.state.organizationDto)
            });


    }



    render() {
        return (
            <div> <br /><br />
                <div className='card col-md-6 offset-md-3'>
                    <h3 className='text-center card-header'> View Employee Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Employee First Name: </strong> {this.state.employeeDto.firstName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee Last Name: </strong> {this.state.employeeDto.lastName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee Email: </strong> {this.state.employeeDto.email}</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'> View Department Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Department Name: </strong> {this.state.departmentDto.departmentName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department Description: </strong> {this.state.departmentDto.departmentDescription}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department code: </strong> {this.state.departmentDto.departmentCode}</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'> View Organization Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong> Organization Name: </strong> {this.state.organizationDto.organizationName} </p>
                        </div>
                        <div className='row'>
                            <p><strong> Organization Description: </strong> {this.state.organizationDto.organizationDescription} </p>
                        </div>
                        <div className='row'>
                            <p><strong> Organization Code: </strong> {this.state.organizationDto.organizationCode} </p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default EmployeeComponent;