document.addEventListener("DOMContentLoaded", () => {
  const signUpButton = document.getElementById("signUp");
  const signInButton = document.getElementById("signIn");
  const container = document.getElementById("container");
  const signUpForm = document.getElementById("signUpForm");

  if (signUpButton && signInButton && container && signUpForm) {
    signUpButton.addEventListener("click", () => {
      container.classList.add("right-panel-active");
    });

    signInButton.addEventListener("click", () => {
      container.classList.remove("right-panel-active");
    });

    signUpForm.addEventListener("submit", (event) => {
      event.preventDefault(); // Prevent the default form submission
      console.log("Submitting signup form");

      const name = document.querySelector("#signUpForm input[name='name']").value;
      const username = document.querySelector("#signUpForm input[name='username']").value;
      const password = document.querySelector("#signUpForm input[name='password']").value;

      console.log("name:", name);
      console.log("username:", username);
      console.log("password:", password);

      // Send the data to the server
      fetch("/user/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ name, username, password }),
      })
        .then((response) => {
          console.log("Response status:", response.status);
          if (!response.ok) {
            throw new Error("Network response was not ok");
          }
          return response.json();
        })
        .then((data) => {
          console.log("Success:", data);
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    });
  } else {
    console.error("One or more elements not found! Check your HTML IDs.");
  }
});