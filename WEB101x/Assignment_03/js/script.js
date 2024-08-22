const regex =
  /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<script>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
function handleSubmit() {
  var emailInput = document.getElementById("inputEmail").value;
  var validationEmail = false;
  validationEmail = regex.test(emailInput);
  if (validationEmail) {
    document.getElementById("invalidateEmail").hidden = true;
    document.getElementById("personal-form").hidden = true;
    document.getElementById("personal-info").hidden = false;
  } else {
    document.getElementById("invalidateEmail").hidden = false;
    document.getElementById("requiredEmail").hidden = true;
  }
}
document.getElementById("inputEmail").addEventListener("input", function (event) {
    var emailInput = event.target.value;
    var validationEmail = false;
    validationEmail = regex.test(emailInput);
    if (validationEmail) {
      document.getElementById("invalidateEmail").hidden = true;
    } else {
      document.getElementById("invalidateEmail").hidden = false;
      document.getElementById("requiredEmail").hidden = true;
    }
  });

  function showInfo(idContent, display){
    
    const skillContent = document.getElementById(idContent);
        if (skillContent.style.display === 'none' || skillContent.style.display === '') {
            skillContent.style.display = display;
            this.event.currentTarget.textContent = 'View Less';
            this.event.currentTarget.insertAdjacentHTML("afterbegin", '<i class="fa-solid fa-lg me-1 fa-caret-up"></i>');
        } else {
            skillContent.style.display = 'none';
            this.event.currentTarget.textContent = 'View more';
            this.event.currentTarget.insertAdjacentHTML("afterbegin", '<i class="fa-solid fa-lg me-1 fa-caret-down"></i>');
        }
  }
