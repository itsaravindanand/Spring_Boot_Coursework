import { createContext, useContext, useState } from "react";

//1: create a context using createContext hook
export const AuthContext = createContext()

//common auth to use across component
export const useAuth = () => useContext(AuthContext)

//2: share the created context with other component

export default function AuthProvider({children}){    
    //put some state in the context
    const [number, setNumber] = useState(10)

    //check if user is authenticated or not
    const [isAuthenticated, setAuthenticated] = useState(false)

    //setInterval( () => setNumber(number+1), 10000)

    //simple object creation in JS
    //const valueToBeShared = {number, isAuthenticated, setAuthenticated}   

    return(
        <AuthContext.Provider value={ {number, isAuthenticated, setAuthenticated} }>
        {children}
        </AuthContext.Provider>
    )
}