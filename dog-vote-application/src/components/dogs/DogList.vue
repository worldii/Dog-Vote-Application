<template lang="">
    <b-container class="pt-3">
    
        <DogListItem v-for="dog in dogList" :key="dog.id" :dog="dog" />
    
    
    </b-container>
</template>

<script>
import DogListItem from "@/components/dogs/DogListItem.vue";
export default {

    data() {
        return {

            dogList: [{
                    id: 1,
                    name: '불독',
                    description: '불독은 중형견으로 근육질이며 튼튼한 체격을 가지고 있습니다. 주목할만한 특징은 피부가 주름있고, 튀어나온 코를 가지고 있다는 것입니다.',
                    detail: '불독은 친근하고 온순한 품종입니다. 불굴의 상징으로 알려져 있으며 끈기와 결단력의 상징으로 인식되기도 합니다. 겉으로는 겁이 많아 보일 수도 있지만 실제로는 극도로 용감하고 충성스러운 성격을 가지고 있습니다.',
                    voteCount: 10,
                    imageUrl: 'https://loremflickr.com/320/240/dog',

                },
                {
                    id: 2,
                    name: '시베리안 허스키',
                    description: '시베리안 허스키는 중형에서 대형까지의 크기를 가지고 있는 견종입니다. 그들은 두꺼운 털과 파란색 눈으로 유명합니다.',
                    detail: '시베리안 허스키는 친근하고 사회적인 성격을 가지고 있으며 뛰어난 체력과 인내력을 갖추고 있습니다. 그들은 운동량이 많고 활동적인 생활 환경을 선호하며 추운 기후에서도 잘 적응합니다.',
                    voteCount: 15,
                    imageUrl: 'https://loremflickr.com/320/240/dog',

                },
                {
                    id: 3,
                    name: '골든 리트리버',
                    description: '골든 리트리버는 대형견으로서 고귀하고 우아한 외모를 가지고 있습니다. 그들은 황금빛 털과 부드러운 털감이 특징입니다.',
                    detail: '골든 리트리버는 친화적이고 온순한 성격을 가지고 있으며 인간과의 관계를 매우 중요시합니다. 그들은 지능적이고 민첩하며 주인의 명령을 잘 따릅니다. 또한, 수영을 좋아하고 사냥과 수색 작업에 능숙합니다.',
                    voteCount: 20,
                    imageUrl: 'https://loremflickr.com/320/240/dog',

                },
                {
                    id: 4,
                    name: 'Golden Retriever',
                    imageUrl: 'https://loremflickr.com/320/240/dog',
                    description: 'The Golden Retriever is a friendly, intelligent, and devoted dog breed.',
                    detail: 'The Golden Retriever is known for its golden-colored coat and its friendly and playful nature. They are great family pets and are often used as therapy dogs or in search and rescue operations.',
                    voteCount: 10
                },
                {
                    id: 12,
                    name: 'Labrador Retriever',
                    imageUrl: 'https://loremflickr.com/320/240/dog',
                    description: 'The Labrador Retriever is a popular and versatile dog breed.',
                    detail: 'Labrador Retrievers are known for their friendly and outgoing temperament. They are highly trainable and often used as assistance dogs, guide dogs, and in various working roles. They come in three main colors: black, yellow, and chocolate.',
                    voteCount: 15
                },
                {
                    id: 13,
                    name: 'German Shepherd',
                    imageUrl: 'https://loremflickr.com/320/240/dog',
                    description: 'The German Shepherd is a courageous and loyal dog breed.',
                    detail: 'German Shepherds are known for their intelligence, versatility, and protective nature. They are often used as police dogs, search and rescue dogs, and as service dogs. They have a distinct appearance with a strong and muscular build.',
                    voteCount: 12
                },
            ]
        };
    },
    components: {
        DogListItem
    }
}
</script>

<style scope="">

</style>

