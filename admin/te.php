<script>
	import Color from "./Color.svelte";
	let value="";
	let colors=[];
	
function handleSubmit(){
		colors = colors.concat(value);
		value = "";
		console.log("colors");
	}
</script>

<style>
</style>

<form on:submit|preventDefault={handleSubmit}>
<input type="text" bind:value="{value}" />
	
</form>

<Color color={value}/>
