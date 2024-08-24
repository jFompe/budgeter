<template>
    <v-container fluid>
        <v-row>
            <v-text-field
                v-model="bankFilter"
                label="Nombre del banco"
            ></v-text-field>
        </v-row>
        <v-row>
            <v-col
                v-for="bank in banks"
                :key="bank.id"
                cols="2"
            >
                <v-card @click="selectBank(bank)">
                        <v-img
                            :src="bank.logo"
                            class="white--text align-end"
                            gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                            height="200px"
                        >
                        <v-card-title v-text="bank.name"></v-card-title>
                    </v-img>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
export default {
    name: 'InstitutionSelector',

    data: { 
        backFilter: ''
    },
    computed: {
        banks() {
            return this.$store.getters.getInstitutions.filter(b -> b.contains(this.backFilter))
        }
    },
    async beforeCreate() {
        await this.$store.dispatch('FETCH_INSTITUTIONS')
    },
    methods: {
        async selectInstitution(institutionId) {
            await this.$store.dispatch('CREATE_ACCOUNT', institutionId)
            window.open(this.$store.getters.getRequisition.link, '_blank')
        }
    }
}
</script>