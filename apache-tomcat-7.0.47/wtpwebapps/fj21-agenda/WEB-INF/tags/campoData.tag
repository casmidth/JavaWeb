<%@ attribute name="dateType" required="true" %>

<input type="text" id="${dateType}" name="${dateType}"/> <br />
<script>
	$("#${dateType}").datepicker({
		dateFormat: 'dd/mm/yy',
		changeYear: true,
		changeMonth: true
		});
</script>