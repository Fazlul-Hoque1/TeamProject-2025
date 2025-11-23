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

// GET ALL EVENTS (home page)

const eventsList = document.getElementById("events-list");

if (eventsList) {
    async function loadEvents() {
        const res = await fetch(`${API_BASE}/all`);
        const events = await res.json();

        eventsList.innerHTML = "";

        events.forEach(event => {
            const div = document.createElement("div");
            div.classList.add("event-card");

            div.innerHTML = `
                <h3>${event.title}</h3>
                <p><strong>Date:</strong> ${event.date}</p>
                <p><strong>Location:</strong> ${event.location}</p>
                <p>${event.description}</p>
            `;

            eventsList.appendChild(div);
        });
    }

    loadEvents();
}