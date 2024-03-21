$(document).ready(function() {
  $('#applicationForm').submit(function(event) {
    // Prevent default form submission
    event.preventDefault();

    // Get form data
    var formData = new FormData(this);

    // Convert form data to JSON object
    var jsonObject = {};
    formData.forEach(function(value, key){
      jsonObject[key] = value;
    });

    // Send form data to backend server
    $.ajax({
      url: 'backend url', // Replace with your backend URL
      method: 'POST',
      contentType: 'application/json',
      data: JSON.stringify(jsonObject),
      success: function(response) {
        console.log('Application submitted successfully:', response);
        // Display success message
        $('#responseMessage').text('Application submitted successfully!').removeClass('error').addClass('success').show();
      },
      error: function(xhr, status, error) {
        console.error('Error submitting application:', error);
        // Display error message
        $('#responseMessage').text('Error submitting application. Please try again.').removeClass('success').addClass('error').show();
      }
    });
  });

  // Add event listener for select change
  $('select[name="internship"]').change(function() {
    var selectedOption = $(this).children("option:selected").val();
    console.log('Selected internship:', selectedOption);
  });
});

function studentPage(){
  window.location.href = "student.html";
}
