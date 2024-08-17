import { createContext, useContext, useState } from "react";

import { apiClient } from "../api/ApiClient";
import { executeBasicAuthenticationService } from "../api/AuthenticationApiService";

//1: create a context using createContext hook
export const AuthContext = createContext()

//common auth to use across component
export const useAuth = () => useContext(AuthContext)

//2: share the created context with other component

export default function AuthProvider({children}){ 
    //check if user is authenticated or not
    const [isAuthenticated, setAuthenticated] = useState(false)

    const [token, setToken] = useState(null)

    const [username, setUsername] = useState(null)

    //function to check the login creds
    async function login(username, password){

        const baToken = 'Basic ' + window.btoa( username + ":" + password )
        try{
            const response = await executeBasicAuthenticationService(baToken)

            if(response.status==200){
                setAuthenticated(true)
                setUsername(username)
                setToken(baToken)
                apiClient.interceptors.request.use(
                    (config) => {
                        console.log('intercepting and adding a token')
                        config.headers.Authorization = baToken
                        return config
                    }
                )
                return true            
            } else {
                logout()
                return false
            }      
        } catch(error){
            logout()
                return false
        }
        
    }
    
    //function for onClick logout for header
    function logout() {
        setAuthenticated(false)
        setToken(null)
        setUsername(null)
    }

    return(
        <AuthContext.Provider value={{ isAuthenticated, login, logout, username, token} }>
        {children}
        </AuthContext.Provider>
    )
}