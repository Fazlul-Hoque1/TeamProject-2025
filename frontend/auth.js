const BASE_URL = "https://eventorganizerapp.up.railway.app/users";

// SIGN UP 
const signupForm = document.getElementById("signup-form");

if (signupForm) {
  signupForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const data = {
      username: document.getElementById("username").value,
      email: document.getElementById("email").value,
      password: document.getElementById("password").value
    };

    try {
      const res = await fetch(`${BASE_URL}/register`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
      });

      
      const text = await res.text();
      console.log("Signup status:", res.status);
      console.log("Signup response:", text);

      if (!res.ok) {
        alert(text || "Signup failed");
        return;
      }

      alert("Account created successfully");
      window.location.href = "login.html";

    } catch (err) {
      console.error(err);
      alert("Signup failed. Check console.");
    }
  });
}

// LOGIN
const loginForm = document.getElementById("login-form");

if (loginForm) {
  loginForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const data = {
      username: document.getElementById("username").value,
      password: document.getElementById("password").value
    };

    try {
      const res = await fetch(`${BASE_URL}/login`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
      });

      const token = await res.text();
      console.log("Login status:", res.status);
      console.log("Login response:", token);

      if (!res.ok) {
        alert(token || "Login failed");
        return;
      }

      // Save token
      localStorage.setItem("token", token);

      alert("Logged in successfully");
      window.location.href = "index.html";

    } catch (err) {
      console.error(err);
      alert("Login failed. Check console.");
    }
  });
}