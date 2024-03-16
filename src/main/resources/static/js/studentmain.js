$(document).ready(function() {
  // Function to fetch internship applications data from the backend
  $.ajax({
      url: '/api/getInternshipApplications', // Replace with your backend URL
      method: 'GET',
      success: function(data) {
          var applicationsList = $('main ul');
          data.forEach(function(application) {
              var listItem = $('<li>');
              var link = $('<a>').attr('href', '/application/' + application.application_id).text(application.internship_title + ' - ' + application.company_name);
              var statusSpan = $('<span>').addClass('status').text(application.application_status);
              listItem.append(link, statusSpan);
              applicationsList.append(listItem);
          });
      },
      error: function(xhr, status, error) {
          console.error('Error fetching internship applications:', error);
      }
  });

  // Function to display the student's name from the backend server
  function displayStudentName() {
      $.ajax({
          url: '/api/getStudentName', // Replace with your backend URL
          method: 'GET',
          success: function(data) {
              $('#welcomeMessage').text('Welcome, ' + data.studentName);
          },
          error: function(xhr, status, error) {
              console.error('Error fetching student name:', error);
          }
      });
  }

  // Call the function to display the student's name when the document is ready
  displayStudentName();
});
