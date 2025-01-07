import { Form } from "react-router-dom";


export default function Login() {
    return(
     <div>
            <h1>Login</h1>
            <Form>
                <div>
                    <label htmlFor="email">Email</label>
                    <input type="email" id="email" name="email" />
                </div>
                <div>
                    <label htmlFor="password">Password</label>
                    <input type="password" id="password" name="password" />
                </div>
                <button type="submit">Login</button>
            </Form>
        </div>
    )
    };
  
    
    
  