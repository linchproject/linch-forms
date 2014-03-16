#Linch Forms

Linch forms lets you create forms where you can define a list of validators for each field.

##Create a form

    Form userForm = new Form()
            .addField("username")
                .addValidator(new RequiredValidator())
                .addValidator(new UserExistsValidator())
            .addField("firstName")
            .addField("lastName")
            .addField("email")
                .addValidator(new RequiredValidator())
                .addValidator(new EmailValidator())
            .addField("password")
                .addValidator(new RequiredValidator())
            .addField("confirmPassword")
                .addValidator(new EqualsValidator("password"))
            .form();

##Fill parameters from request and validate

    userForm.fill(parameterMap).validate();

    if (userForm.isValid()) {
        User user = new User();
        user.setUsername(userForm.get("username").get());
        user.setFirstName(userForm.get("firstName").get());
        user.setLastName(userForm.get("lastName").get());
        user.setEmail(userForm.get("email").get());
        user.setPassword(passwordEncryptor.encryptPassword(userForm.get("password").get()));
        userDao.save(user);

        // redirect to view
    } else {
        // redirect to form
    }

If the form is valid, save entity and redirect to view, otherwise render the form again and display the errors.


##Display errors in template

    <input type="text" class="form-control" id="username" name="username" value="{{form.username}}" required>
    {{#form.username.error}}<span class="help-block">{{.}}</span>{{/form.username.error}}


##Provide a Texter to define your own error messages for each validator and fieldName

    Form i18nForm = new Form(new Texter() {
        @Override
        public String getText(String fieldName, String validatorKey) {
            return i18n.getText("linch.error." + validatorKey + "." + fieldName);
        }
    });