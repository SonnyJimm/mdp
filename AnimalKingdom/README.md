# Animal King Dom

video link [click here.](https://drive.google.com/file/d/1wwypO_5E4mXr4Gm_BKYvUahF8-69rOkR/view?usp=sharing)

## Project structure

```
├── AnimalKingDomApplication.kt // For repository exposure init Dao
├── MainActivity.kt
├── ProjectDatabase.kt          // database init
├── adabter
│   ├── AnimalListAdabpter.kt   // recycler views list adabter
│   ├── FragmentPageAdapter.kt  // bottom nav page adabter
│   └── SpeciesListAdabpter.kt  // recycler views list adabter
├── animal                      // animal fragments all the dep
│   ├── Animal.kt               // model
│   ├── AnimalDAO.kt            // our DAO
│   ├── AnimalDetailFrament.kt  // fragment of animal
│   ├── AnimalDetailFramentViewModel.kt // viewModel
│   ├── AnimalDialog.kt         // dialog for insert data
│   └── AnimalRepository.kt     // repository
└── species                     // species fragments all the dep
    ├── Species.kt              // animal model
    ├── SpeciesDAO.kt           // our DAO
    ├── SpeciesDetailFragment.kt // fragnent for species
    ├── SpeciesDetailViewModel.kt // view model
    ├── SpeciesDialog.kt        // dialog for insert data
    └── SpeciesRepository.kt    // repository
```


