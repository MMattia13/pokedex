import { Route, Routes } from "react-router-dom";


import Login from "./pages/Login";
import Register from "./pages/Register";
import Layout from "./components/Layout";


function App() {
    return (
                <Routes>
                    <Route path="/" element={<Layout />}>
                        <Route path="login" element={<Login />}></Route>
                        <Route path="register" element={<Register />}></Route>
                    </Route>
                </Routes>
       
    );
}

export default App;
