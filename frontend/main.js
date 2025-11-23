const API_BASE = "https://eventorganizerapp.up.railway.app/events";


// CREATE EVENT (form page)

const form = document.getElementById("event-form");

if (form) {
    form.addEventListener("submit", async (e) => {
        e.preventDefault();

        const eventData = {
            title: document.getElementById("title").value,
            date: document.getElementById("date").value,
            location: document.getElementById("location").value,
            description: document.getElementById("description").value
        };

        const res = await fetch(`${API_BASE}/add`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(eventData)
        });

        if (res.ok) {
            alert("Event created!");
            window.location.href = "index.html"; 
        } else {
            alert("Error creating event");
        }
    });
}