import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useAuth } from './security/AuthContext'

function LoginComponent() {

    const [username, setUsername] = useState("aravind")
    const [password, setPassword] = useState('')
    const [showErrorMessage, setShowErrorMessage] = useState(false)
    const navigate = useNavigate();
    const authContext = useAuth()


    function handleUsernameChange(event) {
        //setting the value from the event to the username 
        setUsername(event.target.value)
    }

    function handlePasswordChange(event) {
        //setting the value from the event to the password
        setPassword(event.target.value)

    }

    function handleSubmit() {
        if (authContext.login(username, password)) {
            navigate(`/welcome/${username}`)
        } else {
            setShowErrorMessage(true)
        }
    }
    return (
        <div className="Login">
            <div className="LoginForm">
                <h1>Time to Login!</h1>
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