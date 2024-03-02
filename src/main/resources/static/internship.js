function applyNow(){
const submitForm = document.getElementById("submitform"); // Replace with actual form ID

submitForm.addEventListener("submit", function (event) {
  event.preventDefault(); // Prevent default form submission

  const internshipId = document.getElementById("internship_id").value;
  const internshipTitle = document.getElementById("internship_title").value;
  const location = document.getElementById("location").value;
  const description = document.getElementById("description").value;
  const responsibility = document.getElementById("responsibility").value;
  const startDate = document.getElementById("startdate").value;
  const endDate = document.getElementById("enddate").value;

  const data = {
    internshipId: internshipId,
    internshipTitle: internshipTitle,
    location: location,
    description: description,
    responsibility: responsibility,
    startDate: startDate,
    endDate: endDate,
  };

  const jsonData = JSON.stringify(data); // Convert data object to JSON string

  // Replace with your actual server-side script URL
  fetch("/submit_internship", {
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
function homePage(){
    window.location.href= "homepage.html"
}