const mentorId = '[Mentor ID]';


fetch(`/mentor/${mentorId}`)
  .then(response => response.json())
  .then(data => {
    document.getElementById('mentorName').textContent = data.name;
    document.getElementById('mentorNamePlaceholder').textContent = data.name;
  })
  .catch(error => console.error('Error fetching mentor:', error));

fetch(`/mentor/${mentorId}/mentees`)
  .then(response => response.json())
  .then(data => {
    const menteesList = document.getElementById('menteesList');
    menteesList.innerHTML = ''; 
    data.forEach(mentee => {
      const listItem = document.createElement('li');
      listItem.innerHTML = `<a href="/mentee/${mentee.id}">${mentee.name}</a> - ${mentee.major}`;
      menteesList.appendChild(listItem);
    });
  })
  .catch(error => console.error('Error fetching mentees:', error));
