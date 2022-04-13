<template>
  <div>
    <h1>Check out some helpful Pathway information below!</h1>
    <router-link :to="{ name: 'EmployerFollowUp' }">
      <h3>Learn about how best to follow up with an employer.</h3>
    </router-link>
    <router-link :to="{ name: 'InterviewFashion' }">
      <h3>Dress to impress for your interviews.</h3>
    </router-link>
    <router-link :to="{ name: 'InterviewPrep' }">
      <h3>Prepare for that interview you're so excited about.</h3>
    </router-link>  
    <router-link :to="{ name: 'StarQuestions' }">
      <h3>Learn how to ace those STAR questions.</h3>
    </router-link>  
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>