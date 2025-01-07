import { Link } from "react-router-dom";


export function Navbar() {
    return (
        <nav className="border-b">
            <div className="flex h-16 items-center px-4">
                
                <div className="flex-1">
                    <Link to="/pokedex" className="text-2xl font-semibold">Pokedex</Link>
                </div>
                <div>
                    <Link to="/login" className="text-blue-500">Login</Link>
                </div>
            </div>
        </nav>
    );
}
