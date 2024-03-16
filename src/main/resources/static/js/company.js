function submitCompanyForm(){
    const form = document.getElementById("companyform"); // Replace with actual form ID
  
  form.addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent default form submission
  
    const companyId = document.getElementById("company_id").value;
    const companyName = document.getElementById("company_name").value;
    const companyEmail = document.getElementById("company_email").value;
    const companyContact = document.getElementById("company_contact").value;
    const password = document.getElementById("company_password").value;
    const confirmPassword = document.getElementById("confirm_password").value;
  
    // Basic validation to ensure passwords match
    if (password !== confirmPassword) {
      alert("Passwords do not match!");
      return; // Prevent further processing if passwords don't match
    }
  
    const data = {
     companyId: companyId,
     companyName: companyName,
     companyEmail: companyEmail,
     companyContact: companyContact,
     password: password,
    };
  
    const jsonData = JSON.stringify(data); // Convert data object to JSON string
  
    // Replace with your actual server-side script URL
    fetch("server url", {
      method: "POST", // Ensure POST method for sending data
      headers: {
        "Content-Type": "application/json", // Set content type to JSON
      },
      body: jsonData, // Send the JSON string as the body
    })
      .then((response) => response.text())
      .then((data) => {
        console.log("Response from server:", data);
        alert('Your message has been successfully sent!');
      })
      .catch((error) => {
        console.error("Error:", error);
        alert('Oops! Something went wrong. Please try again later.');
      });
  });
  
  }
  function submitContactForm(event) {
    // Prevent the default form submission behavior
    event.preventDefault();

    // Get form data
    const formData = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        message: document.getElementById('message').value
    };

    // Submit form data to backend
    fetch('backend url', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log('Contact form submission successful:', data);
        alert('Your message has been successfully sent! We will get back to you soon.');
        document.getElementById('name').value = '';
        document.getElementById('email').value = '';
        document.getElementById('message').value = '';
    })
    .catch(error => {
        console.error('There was a problem with your fetch operation:', error);
        alert('Oops! Something went wrong. Please try again later.');
    });
}
