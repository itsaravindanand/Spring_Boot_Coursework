import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useAuth } from './security/AuthContext'

function LoginComponent() {

    const [username, setUsername] = useState("aravind")
    const [password, setPassword] = useState('')
    const [showSuccessMessage, setShowSuccessMessage] = useState(false)
    const [showErrorMessage, setShowErrorMessage] = useState(false)
    const navigate = useNavigate();
    const authContext = useAuth()


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
        if (authContext.login(username, password)) {
            //console.log("success")
            setShowSuccessMessage(true)
            setShowErrorMessage(false)
            navigate(`/welcome/${username}`)
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

export default LoginComponent