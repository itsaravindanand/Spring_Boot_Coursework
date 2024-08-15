import { createContext, useContext, useState } from "react";

//1: create a context using createContext hook
export const AuthContext = createContext()

//common auth to use across component
export const useAuth = () => useContext(AuthContext)

//2: share the created context with other component

export default function AuthProvider({children}){ 

    //check if user is authenticated or not
    const [isAuthenticated, setAuthenticated] = useState(false)
    //function to check the login creds
    function login(username, password){
        if(username==='aravind' && password==='password'){
            setAuthenticated(true)
            return true            
        } else {
            setAuthenticated(false)
            return false
        }      
    }
    //function for onClick logout for header
    function logout() {
        setAuthenticated(false)
    }

    return(
        <AuthContext.Provider value={{ isAuthenticated, login, logout} }>
        {children}
        </AuthContext.Provider>
    )
}