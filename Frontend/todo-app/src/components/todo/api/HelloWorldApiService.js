import axios from 'axios'
import { apiClient } from './ApiClient'

// export function retrieveHelloWorldBean(){
//     return axios.get('http://localhost:8080/hello-world-bean')
// }

export const retrieveHelloWorldBean 
    = () => axios.get('http://localhost:8080/hello-world-bean')

// export const retrieveHelloWorldPathVariable
//     = (username) => apiClient.get(`/hello-world/path-variable/${username}`)

//Response to preflight request doesn't pass access control check => Authorization header
export const retrieveHelloWorldPathVariable
    = (username, token) => apiClient.get(`/hello-world/path-variable/${username}`,{
        // headers: {
        //     Authorization: token
        // }
    })

