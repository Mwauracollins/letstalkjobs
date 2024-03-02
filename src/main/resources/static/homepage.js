function loginStudent(){
    const form = document.getElementById("studentform"); // Replace with actual form ID
  
  form.addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent default form submission
  
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
  
  
    const data = {
      email: email,
      password: password,
    };
  
    const jsonData = JSON.stringify(data); // Convert data object to JSON string
  
    // Replace with your actual server-side script URL
    fetch("/register", {
      method: "POST", // Ensure POST method for sending data
      headers: {
        "Content-Type": "application/json", // Set content type to JSON
      },
      body: jsonData, // Send the JSON string as the body
    })
      .then((response) => response.text())
      .then((data) => {
        console.log("Response from server:", data);
        // Handle the response from the server (e.g., display success/error message, redirect)
      })
      .catch((error) => {
        console.error("Error:", error);
        // Handle potential errors during submission (e.g., network issues)
      });
  });
  
  }
  
  function loginMentor(){
    const form = document.getElementById("mentorform"); // Replace with actual form ID
  
  form.addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent default form submission
  
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
  
  
    const data = {
      email: email,
      password: password,
    };
  
    const jsonData = JSON.stringify(data); // Convert data object to JSON string
  
    // Replace with your actual server-side script URL
    fetch("/register", {
      method: "POST", // Ensure POST method for sending data
      headers: {
        "Content-Type": "application/json", // Set content type to JSON
      },
      body: jsonData, // Send the JSON string as the body
    })
      .then((response) => response.text())
      .then((data) => {
        console.log("Response from server:", data);
        // Handle the response from the server (e.g., display success/error message, redirect)
      })
      .catch((error) => {
        console.error("Error:", error);
        // Handle potential errors during submission (e.g., network issues)
      });
  });
  
  }

  function redirectInternship(){
    const form = document.getElementById("redirectIntern"); // Replace with actual form ID
  
  form.addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent default form submission
  
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
  
  
    const data = {
      email: email,
      password: password,
    };
  
    const jsonData = JSON.stringify(data); // Convert data object to JSON string
  
    // Replace with your actual server-side script URL
    fetch("/register", {
      method: "POST", // Ensure POST method for sending data
      headers: {
        "Content-Type": "application/json", // Set content type to JSON
      },
      body: jsonData, // Send the JSON string as the body
    })
      .then((response) => response.text())
      .then((data) => {
        console.log("Response from server:", data);
        // Handle the response from the server (e.g., display success/error message, redirect)
      })
      .catch((error) => {
        console.error("Error:", error);
        // Handle potential errors during submission (e.g., network issues)
      });
  });
  
  }
  
  





