<template>
  <div class="sidebar">
    <button class="button">
        <p>
            I need information about something in Pathway.
        </p>
    </button>
    <button class="button">
        <p>
        I need information about the curriculum.
        </p>
     </button>
     <button class="button">
         <p>
        What assignments are due today?
         </p>
     </button>
     <button class="button">
         <p>
        Where can I learn more about Java?
         </p>
     </button>
     <button class="button">
         <p>
        Where can I learn more about Vue.js?
         </p>
     </button>
     <button class="button">
         <p>
        What else can you help with?
         </p>
     </button>     
  </div>
</template>

<script>
export default {
    name: "sidebar"

}
</script>

<style style="scoped">
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap');

.sidebar {
    background-color: #B13D59;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
    height: 100%;
}

.button {
    font-family: 'Roboto', sans-serif;
    background-color: #F5F7F3;
    border: none;
    color: #1F2B4A;
    text-align: center;
    border-radius: 4px;
    margin: 5px;
    width: 90%;
}
</style>