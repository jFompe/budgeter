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
                v-for="institution in institutions"
                :key="institution.id"
                cols="2"
            >
                <v-card 
                    height="300px"
                    :image="institution.logo"
                    @click="selectInstitution(institution)"
                >
                    <v-card-title
                        style="background-color: black; opacity: 0.7;"
                        v-text="institution.name"
                    ></v-card-title>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
export default {
    name: 'InstitutionSelector',

    data: () => ({
        bankFilter: ''
    }),
    computed: {
        institutions() {
            const filter = this.bankFilter.toLowerCase()
            return this.$store.getters.getInstitutions
                .filter(inst => inst.name.toLowerCase().includes(filter))
        }
    },
    async beforeCreate() {
        this.$store.dispatch('SET_LOADING', true)
        await this.$store.dispatch('FETCH_INSTITUTIONS')
        this.$store.dispatch('SET_LOADING', false)
    },
    methods: {
        async selectInstitution(institution) {
            this.$store.dispatch('SET_LOADING', true)
            await this.$store.dispatch('CREATE_ACCOUNT', institution)
            window.open(this.$store.getters.getRequisitionLink, '_self') // _blank for new tab
            this.$store.dispatch('SET_LOADING', false)
        }
    }
}
</script>