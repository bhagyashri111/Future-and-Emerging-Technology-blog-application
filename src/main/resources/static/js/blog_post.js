// JavaScript code to handle form submission asynchronously

document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('#comment-form');

    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the default form submission

        // Collect form data
        const formData = new FormData(form);

        // Send form data asynchronously using fetch API
        fetch(form.action, {
            method: form.method,
            body: formData
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json(); // Assuming the response is in JSON format
            })
            .then(data => {
                // Handle successful submission
                console.log('Comment submitted successfully:', data);
                // You can update the UI as needed, e.g., display a success message or refresh the comment section
            })
            .catch(error => {
                // Handle errors
                console.error('Error submitting comment:', error);
                // You can display an error message to the user or handle the error in any appropriate way
            });
    });
});