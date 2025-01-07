import { Link } from "react-router-dom";


export function Navbar() {
    const user = null;

    function logout(event: MouseEvent<HTMLButtonElement, MouseEvent>): void {
        throw new Error("Function not implemented.");
    }

    return (
        <nav className="border-b">
            <div className="flex h-16 items-center px-4">
                
                <div className="flex-1">
                    <Link to="/pokedex" className="text-2xl font-semibold">Pokedex</Link>
                </div>
                <div>
                    {user ? (
                        <button onClick={logout} className="text-blue-500">Logout</button>
                    ) : (
                        <Link to="/login" className="text-blue-500">Login</Link>
                    )}
                </div>
            </div>
        </nav>
    );
}
