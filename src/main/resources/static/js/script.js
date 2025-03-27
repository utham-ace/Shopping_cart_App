$(function(){
	
	// Reset Validation
 var $userRegister=$("#userRegister");
 $userRegister.validate({
	rules:{
	   name:{
		required:true,
		lettersonly:true
		
	}
	,
	email: {
		required: true,
		space: true,
		email: true
		},
		mobno: {
			required : true,
			space : true,
			numericOnly: true,
			minlength: 10,
			maxlength: 12
		},
		password: {
			required : true,
			space : true,
			
		},
		confirmpassword: {
			required: true,
			space: true,
			equalTo: '#pass'
		},
		address: {
			required: true,
			space: true
		},
		city: {
			required: true,
			space: true
		},
		state: {
			required:true,
			space: true
		},
		pincode: {
			required: true,
			space: true,
			numericOnly: true
            },
			img:{
				required:true,
			}
		
	},
	
	messages:{
		name:{
			required:'name required',
			lettersonly:'invalid name'
			
		},
		
		email: {
			required: 'Email must be required',
			space: 'space not allowed'
			
			},
		password: {
			required: 'password must be required',
			space: 'space not allowed'
		},
		confirmpassword:{
			required: 'confirm password must be required',
			space: 'space not allowed',
			equalTo: 'password mismatch'
		},	
		address: {
			requried: 'address must be requried',
			all:'invalid'
		},
		city: {
			requried: 'city must be requried',
			space: 'space not allowed'
		},
		
		mobileNumber: {
			requried: 'mob no must be requried',
			space: 'space not allowed',
			numericOnly: 'invalid mob no',
			minlength: 'min 10 digit',
			maxlength: 'max 12 digit'
		}
			
		}
   })
})

// Reset Password Validation

$userRegister.validate({
rules:{
	password: {
				required : true,
				space : true,
				
			},
			confirmPassword: {
				required: true,
				space: true,
				equalTo: '#pass'
			},
    },
	messages:{
		password: {
					required: 'password must be required',
					space: 'space not allowed'
				},
		confirmpassword:{
					required: 'confirm password must be required',
					space: 'space not allowed',
						equalTo: 'password mismatch'
						}
	}
	}),
	
	
	

jQuery.valiator.addMethod('lettersonly',function(value, element){
	return /^[^-\s][a-zA-z_\s-]+$/ .test(value);
});

jQuery.valiator.addMethod('space',function(value, element) {
	return /^[^-s]+$/.test(value);
});

jQuery.valiator.addMethod('all',function(value, element){
	return /^[^-\s][a-zA-Z0-9_,.\s-]+$/ .test(value);
});

jQuery.valiator.addMethod('numericOnly',function(value, element){
	return /^[0-9]+$/ .test(value);
});
