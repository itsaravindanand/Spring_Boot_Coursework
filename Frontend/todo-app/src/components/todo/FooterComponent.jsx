import { useAuth } from "./security/AuthContext"

function FooterComponent() {
    //const authContext = useContext(AuthContext)
    const authContext = useAuth()
    //console.log(`Foot Component- ${authContext.number}`)

    return (
        <footer className="footer">
            <div className="container">
                Your Footer
            </div>
        </footer>
    )
}

export default FooterComponent