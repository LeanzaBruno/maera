import { Container, Nav, Navbar, NavbarBrand } from "react-bootstrap";
import Searcher from "../pages/Searcher";


export default function Topbar(){

    return (
        <Navbar>
            <Container className="justify-content-between align-items-center">
                <NavbarBrand href="/" className="col-1 main-title">MAERA</NavbarBrand>
                <Searcher />
                <Nav className="col-1">
                    <Nav.Link href="/sigmets">Sigmets</Nav.Link>
                    <Nav.Link href="/sigmets">Pronarea</Nav.Link>
                </Nav>
        </Container>
       </Navbar>
    );
}