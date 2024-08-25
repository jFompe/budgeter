<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
      clipped-left
    >

      <template v-slot:prepend>
        <v-progress-circular
          v-if="loading"
          color="white"
          indeterminate
        ></v-progress-circular>
  
        <v-app-bar-nav-icon 
          v-else
          @click.stop="drawer = !drawer"
        />
      </template>


      <v-toolbar-title
        @click="$router.push('/')"
      >Budgeter</v-toolbar-title>

      <v-spacer></v-spacer>

      <v-btn
        icon
        class="mr-1"
        @click.stop="cards = !cards"
      >
        <v-icon>mdi-table</v-icon>
      </v-btn>
    </v-app-bar>

    <!-- <v-navigation-drawer
      v-model="drawer"
      absolute
      temporary
    >
      <v-btn
        @click="setInitialDates"
      >Visión Global</v-btn>
      <v-date-picker
        type="month"
        full-width
        :min="minDate"
        @change="changeMonth"
      ></v-date-picker>
    </v-navigation-drawer> -->

    <!-- <v-navigation-drawer
      v-model="cards"
      absolute
      temporary
      right
    >
      <v-list>
        <v-list-item
          v-for="chart in charts"
          :key="chart.name"
        >
          <v-btn
            variant="text"
            @click="$router.push(chart.route)"
          >
            <v-icon>
              {{ chart.icon }}
            </v-icon>
            <span class="ml-4">{{ chart.name }}</span>
          </v-btn>
        </v-list-item>
      </v-list>
    </v-navigation-drawer> -->

    <v-main>
      <RouterView />
    </v-main>

    <AppFooter />
  </v-app>
</template>

<script>
import { RouterView } from 'vue-router';

export default {
  data() {
    return {
      
    }
  },
  computed: {
    loading() {
      return this.$store.getters.isLoading
    }
  }
}
</script>
