function registerMentor(){
    const form = document.getElementById("formregistration"); // Replace with actual form ID
  
  form.addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent default form submission
  
    const firstName = document.getElementById("first_name").value;
    const lastName = document.getElementById("last_name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirm_password").value;
  
    // Basic validation to ensure passwords match, replace with more robust validation
    if (password !== confirmPassword) {
      alert("Passwords do not match!");
      return; // Prevent further processing if passwords don't match
    }
  
    const data = {
      firstName: firstName,
      lastName: lastName,
      email: email,
      password: password,
    };
  
    const jsonData = JSON.stringify(data); // Convert data object to JSON string
  
    // Replace with your actual server-side script URL
    fetch("/submit", {
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
  
  function homepage(){
    window.location.href= "homepage.html"
  }