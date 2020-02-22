# RegistrationUI Manual Testing

# Test when everything is filled out properly.
| Actions Taken | Expected Results |
|---------------|------------------|
| Fill out the first name, last name, email, and password with appropriate information.  | All the text fields are filled out. |
| Click on the Confirm Button. | Message saying registration successful and prompting back to the loginUI |

# Test when email field is wrong.
| Actions Taken | Expected Results |
|---------------|------------------|
| Fill out the first name, last name and password with appropriate information. The information in the email field is not a valid email. | All the text fields are filled out. |
| Click on the Confirm Button | Message saying that email is invalid. |

# Test when password field doesn't meet the minimum criteria.
| Actions Taken | Expected Results |
|---------------|------------------|
| Fill out the first name, last name and email with appropriate information. Put a password that doesn't meet the minimum requirements for security. | All the text fields are filled out. |
| Click on the Confirm Button | Message saying password requirement not met. |

# Test when no fields are filled in.
| Actions Taken | Expected Results |
|---------------|------------------|
| Click on the Confirm Button | Message saying first name, last name, email, and password are missing. |

# Test when first name field is missing.
| Actions Taken | Expected Results |
|---------------|------------------|
| Fill out the last name, email, and password with appropriate information. | All the text fields are filled out except first name. |
| Click on the Confirm Button | Message saying first name is missing. |

# Test when last name field is missing.
| Actions Taken | Expected Results |
|---------------|------------------|
| Fill out the first name, email, and password with appropriate information. | All the text fields are filled out except last name. |
| Click on the Confirm Button | Message saying last name is missing. |

# Test when email field is missing.
| Actions Taken | Expected Results |
|---------------|------------------|
| Fill out the first name, last name, and password with appropriate information. | All the text fields are filled out except email. |
| Click on the Confirm Button | Message saying email is missing. |

# Test when password field is missing.
| Actions Taken | Expected Results |
|---------------|------------------|
| Fill out the first name, last name, and email with appropriate information. | All the text fields are filled out except password. |
| Click on the Confirm Button | Message saying password is missing. |


