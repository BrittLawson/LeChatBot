<template>
  <div>
    <header>
      <h1>Interview Fashion</h1>    
    </header>
    <section>
      <ul>
        <li>
          Dress to impress
          <ul>
            <li>
              Suit and tie, blazer, button-up, dress slacks, or skirt/dress
            </li>
            <li>
              Wear neutral colors
            </li>
            <li>
              Avoid crazy patterns
            </li>
          </ul>
        </li>
        <li>
          Trim facial hair
        </li>
        <li>
          Keep hair out of your face and pulled back
        </li>
        <li>
          Keep jewelry and makeup to a minimum
        </li>
        <li>
          One spray of perfume/cologne will go a long way
        </li>
      </ul>
    </section>
    <section>
      Why not also check out what 
      <a href="https://www.instagram.com/p/B0Ys1V5hbPM/?utm_source=ig_embed&ig_rid=f86f0329-e8d9-4eb1-8dd7-2427dcf2428c" target="_blank">Queer Eye's Tan France</a> 
      has to say about dressing for interviews?
    </section>  
    <footer class="button-footer">
        <button class="pathway-topic-button" v-on:click="pathway()" :disabled="$store.state.nameOfCurrentUser==''">
        Take me back to the Pathway home page.   
        </button>
        <br>
        <button class="pathway-topic-button" v-on:click="home()" :disabled="$store.state.nameOfCurrentUser==''">
        Take me back to the main Chatbot home page.
      </button>
      </footer>
  </div>
</template>

<script>
export default {
  name: "interview-fashion-info",
  methods: {
    pathway () {
            this.$router.push("/Pathway");
        },
    home () {
      this.$router.push("/")
    }
  }

}
</script>

<style>

</style>