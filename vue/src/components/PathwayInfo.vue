<template>
  <div>
    <div class="pathway-link" id="link-1">
      <router-link :to="{ name: 'EmployerFollowUp' }" >
        Learn about how best to follow up with an employer.
      </router-link>
    </div>
    <div class="pathway-link" id="link-2">
      <router-link :to="{ name: 'InterviewFashion' }" >
        Dress to impress for your interviews.
      </router-link>
    </div>
    <div class="pathway-link" id="link-3">
      <router-link :to="{ name: 'InterviewPrep' }" >
        Prepare for that interview you're so excited about.
      </router-link>
    </div>
    <div class="pathway-link" id="link-4">  
      <router-link :to="{ name: 'StarQuestions' }" >
        Learn how to ace those STAR questions.
      </router-link>  
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>
  .pathway-link {
    /* padding-top: 2%;
    padding-left: 2%;
    margin: 1%;
    background-color: #1F2B4A;
    font-family: 'Roboto', sans-serif;
    color: #f5f7f3;
    text-decoration: none; */
    /* unvisited link */

    background-color: #1F2B4A;
    color: #F5F7F3;
    border-radius: 8px;
    max-height: 10vh;
    margin: 20px;
    padding: 10px;
    align-items: center;
    font-size: 2vw;
    text-align: center;
    min-height: 7%;
 
  }

a:link {
  color: white;
  text-decoration: none;
}

a:visited {
  color: white;
  text-decoration: none;
}


</style>