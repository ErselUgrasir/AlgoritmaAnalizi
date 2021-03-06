<?php

/** 
 10,100,1.000,10.000,100.000 elemanlı diziler 100'er kere çalıştırılıp dizide bulunan elemanların
 ortalama kaç denemede bulunduğu gösterilmiştir($total / 100). Eğer seçilen eleman dizide yoksa max. deneme sayısı
 göz önüne alınmıştır. İlgili grafik binarySearchGraph.jpg olarak kaydedilmiştir.
 **/

/**
 $try bir elamanın kaçıncı seferde bulunduğu
 $elemanSayisi dizinin kaç elemanlı olacağı
 $maxNumber aranacak sayının değerinin üst sınırı
 'createArray' girilen $elemanSayisi elemanlı dizi oluşturur
 'linearSearch' dizideki $arananSayi değerini artan index sırasıyla arar
 $return -1(bulunamadı) yada $try değerini döndürür
 'binarySearch' dizideki $arananSayi değerini ikili arama algoritmasıyla arar
 **/

$try = 0;

$elemanSayisi = 100000;

$maxNumber = $elemanSayisi;

$myArray = createArray($elemanSayisi);

$total = 0;

for ($i=0; $i < 100; $i++) { 

	$arananSayi = rand(1,$maxNumber);

	// $result değeri için kullanilabilir fonksiyonlar : 'linearSearch' ve 'binarySearch'
	$result = binarySearch($myArray,$arananSayi);

	if ($result == -1) {

		echo "----- Dizide ".$arananSayi." diye bir sayı bulamadım.";

	} else {

		echo "+++".$arananSayi." sayısını ".$try.". denemede buldum.";
		
	}

	$total += $try;
	
	$try = 0;

	echo "<br />";

	if($i == 99){ echo $total / 100; }
}

function binarySearch($myArray,$number){

	$left = 0;
    $right = count($myArray) - 1;

    while ($left <= $right) {
        $mid = ($left + $right) / 2;
        
		$GLOBALS["try"]++;

        if ($myArray[$mid] == $number) {
            return $GLOBALS["try"];
        } elseif ($myArray[$mid] > $number) {
            $right = $mid - 1;
        } elseif ($myArray[$mid] < $number) {
            $left = $mid + 1;
        }
    }

    return -1;

}

function linearSearch($myArray,$number){

	foreach ($myArray as $value) {
		
		$GLOBALS["try"]++;

		if ($value == $number) {
			
			return $GLOBALS["try"];

		}

	}

	return -1;

}

function createArray($index){

	$arrayX = array();

	for ($i = 0; $i < $index; $i++) { 
		
		array_push($arrayX, rand(1,$GLOBALS["maxNumber"]));

	}

	sort($arrayX);

	return $arrayX;

}

?>