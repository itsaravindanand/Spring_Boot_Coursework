import { useState } from 'react'
import './TodoApp.css'
import { BrowserRouter, Routes, Route, useNavigate } from 'react-router-dom'


export default function TodoApp() {
    return (
        <div className="TodoApp">
            {/* Todo Management Application */}
            <BrowserRouter>
                <Routes>
                    <Route path='*' element={<ErrorComponent />}></Route>
                    <Route path='/' element={<LoginComponent />}></Route>
                    <Route path='/login' element={<LoginComponent />}></Route>
                    <Route path='/welcome' element={<WelcomeComponent />}></Route>
                </Routes>
            </BrowserRouter>
        </div>
    )
}

function LoginComponent() {

    const [username, setUsername] = useState("aravind")
    const [password, setPassword] = useState('')
    const [showSuccessMessage, setShowSuccessMessage] = useState(false)
    const [showErrorMessage, setShowErrorMessage] = useState(false)
    const navigate = useNavigate();


    function handleUsernameChange(event) {
        //console.log(event.target.value)
        //setting the value from the event to the username 
        setUsername(event.target.value)
    }

    function handlePasswordChange(event) {
        //console.log(event.target.value)
        //setting the value from the event to the password
        setPassword(event.target.value)

    }

    function handleSubmit() {
        // console.log(username)
        // console.log(password)
        if (username === "aravind" && password === "password") {
            //console.log("success")
            setShowSuccessMessage(true)
            setShowErrorMessage(false)
            navigate('/welcome')
        } else {
            setShowErrorMessage(true)
            setShowSuccessMessage(false)
            //console.log("failed")
        }
    }
    return (
        <div className="Login">
            <div className="LoginForm">
                <h1>Time to Login!</h1>
                {showSuccessMessage && <div className="successMessage">Authenticated Successfully</div>}
                {showErrorMessage && <div className="errorMessage">Authentication Failed. Check Creds!.</div>}
                <div>
                    <label>Username</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange} />
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange} />
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>
                        Login
                    </button>
                </div>
            </div>
        </div>
    )
}

function WelcomeComponent() {
    return (
        <div className="WelcomeComponent">
            <h1>Welcome User</h1>
            <div>
                Welcome Component
            </div>
        </div>
    )
}

function ErrorComponent() {
    return (
        <div className="ErrorComponent">
            <h1>We are working really hard!</h1>
            <div>
                Apologies for the 404. Reach out to our team at ABC-DEF-GHIJ.
            </div>
        </div>
    )
}