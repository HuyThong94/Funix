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
