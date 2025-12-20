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