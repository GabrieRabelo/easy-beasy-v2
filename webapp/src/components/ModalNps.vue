<template>
    <div>

        <b-modal hide-header-close hide-footer no-close-on-backdrop no-close-on-esc id="modalNps"
            title="Ajude-nos a melhorar!"
            :header-bg-variant= "headerBgVariant"
            :header-text-variant = "headerTextVariant">
            <p class="mt-20">
                <strong>Em uma escala de 1 a 10, o quanto você recomendaria o nosso serviço para alguém?</strong>
            </p>
            <b-button
                    class="ml-6 font nps-button"
                    squared
                    variant="outline-secondary"
                    v-on:click="setScore(number), changeBackGroundColor($event), resetScoreColor()"
                    v-for="number in 10"
                    :key="number">{{ number }}
            </b-button>

            <label class="mt-20"><strong>Qual a razão da sua nota?</strong></label>
            <b-input id="input" v-model="nps.comments"></b-input>

            <b-container fluid>
                <b-row class="mb-3">
                    <b-col md="1.5" class="ml-md-auto">
                        <b-button squared type="submit" v-on:click="submitScore()"
                            class="answer-btn mt-20" >Enviar
                        </b-button>
                    </b-col>
                </b-row>
            </b-container>
        </b-modal>
    </div>
</template>

<script>
    import netPromoterScoreService from '@/services/netPromoterScore.service.js'

    export default {
        name: "ModalNps",
        props: {
            callBack: { type: Function },
        },
        data: () => ({
            nps : {
                score: 0,
                comments: "",
            },
            headerBgVariant: 'info',
            headerTextVariant: 'light'
        }),
        methods: {
            setScore(number) {
                this.nps.score = number;
            },
            submitScore() {
                if(this.nps.score !== 0){
                    netPromoterScoreService.save(this.nps)
                    this.callBack()
                    this.$bvModal.hide('modalNps')
                }else{
                    this.scoreNotSelected()
                }

            },
            changeBackGroundColor(event) {
                const allButtons = document.querySelectorAll(".nps-button");
                for (let i = 0; i < allButtons.length; i++) {
                    allButtons[i].style.backgroundColor = "#ffffff";
                }
                const button = event.currentTarget;
                button.style.background = "#bcbcbc";
            },
            scoreNotSelected(){
                const allButtons = document.querySelectorAll(".nps-button");
                allButtons.forEach(element => {
                    let opacity = 0.5;
                    const timer = setInterval(function () {
                        element.classList.add("scoreNotSelected");                        
                    }, 50);
                });
            },
            resetScoreColor(){
                const allButtons = document.querySelectorAll(".nps-button");
                allButtons.forEach(element => {
                    element.classList.add("resetScoreColor");
                    });
            }
        }
    };
</script>


<style lang="scss" scoped>
    @import '@/assets/scss/config/variables.scss';
    .ml-6 {
        margin-left: 6px;
    }
    .answer-btn {
        background-color: $primary-color;
        border-color:$primary-color;
    }
    .answer-btn:hover{
        background-color:$primary-color;
        border-color:$primary-color;
    }
    .mt-20{
        margin-top: 20px;
        font-family: $primary-font-family;
    }
    .scoreNotSelected{
        border-color: rgba(255, 0, 0, 0.5);
        box-shadow: 0px 0px 3px red;
    }
    .resetScoreColor{
        border-color: rgb(108, 117, 125);
        box-shadow: none;
    }
</style>
