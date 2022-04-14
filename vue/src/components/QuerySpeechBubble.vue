<template>
  <div class="message-container">
      <span class="query-bubble">
            {{ speechText }}
      </span>
  </div>
</template>

<script>
export default {
    name: "query-speech-bubble",
    props: ["speechText"]
}
</script>

<style>
.message-container {
    display: flex;
}

.query-bubble {
    background-color: #1F2B4A;
    color: #F5F7F3;
    border-radius: 8px;
    flex-grow: 1;
    max-height: 10vh;
    margin-left: 20px;
    margin-right: 20px;
    padding: 5px;
    display: inline-flex;
    justify-content: center;
    align-items: center;
    font-size: 3vh;
    text-align: center;
    min-height: 7%;
}
</style>